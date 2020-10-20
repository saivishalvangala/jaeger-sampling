package com.cgi.ogs.exampleapp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.ogs.exampleapp.constants.Constant;
import com.cgi.ogs.exampleapp.constants.Constants;
import com.cgi.ogs.exampleapp.trace.TraceIt;

@RestController
@RequestMapping("/api")
public class Controller
{
    @Value("${path}")
    String path;

    @GetMapping("/hi")
    @TraceIt
    public ResponseEntity<String> getHi()
    {
        return new ResponseEntity<>("Hi", HttpStatus.OK);
    }

    @GetMapping("/name")
    @TraceIt
    public ResponseEntity<String> getName()
    {
        return new ResponseEntity<>("Hi", HttpStatus.OK);
    }

    @GetMapping("/hello")
    @TraceIt
    public ResponseEntity<String> getHeloo()
    {
        return new ResponseEntity<>("Hi", HttpStatus.OK);
    }

    @PostMapping("/email")
    @TraceIt
    public ResponseEntity<String> sendEmailToTopic(@RequestBody final EmailObject emailobject)
    {
        String extension;
        String templateName = emailobject.getTemplateName();
        if (templateName.contains(Constant.DOT))
        {
            extension = templateName.substring(templateName.indexOf(Constant.DOT) + 1).trim();
            if (extension.contains(Constant.DOT))
            {
                return new ResponseEntity<>(Constant.EXTENSION_NOT_SUPPORTED + Constant.DOT + extension
                        + Constant.EMAIL_NOT_SENT + templateName, HttpStatus.CONFLICT);

            }
            if (!Constant.FILE_EXTENSION.equals(Constant.DOT + extension))
            {
                return new ResponseEntity<>(Constant.EXTENSION_NOT_SUPPORTED + Constant.DOT + extension
                        + Constant.EMAIL_NOT_SENT + templateName, HttpStatus.CONFLICT);

            }
            templateName = templateName.substring(0, templateName.indexOf(Constant.DOT));
        }
        templateName = templateName.toUpperCase();
        templateName += Constant.FILE_EXTENSION;

        String body = null;
        String subject = null;
        String from = null;
        String to = null;
        String cc = null;
        String bcc = null;
        String mandatory = null;
        path = Constants.WORK_DIR + templateName;
        final Map<String, String> map = emailobject.getTemplateMap();
        final File f = new File(path);
        System.out.println("path is--------------------:" + path);
        try (BufferedReader br = new BufferedReader(new FileReader(path));)
        {
            final Map<String, String> templateMap = new HashMap<>();
            for (final Map.Entry<String, String> entry : map.entrySet())
            {
                templateMap.put("{$" + entry.getKey() + "}", entry.getValue());
            }
            mandatory = br.readLine().trim();
            if (mandatory.length() > (mandatory.indexOf(":") + 1))
            {
                mandatory = mandatory.substring(mandatory.indexOf(":") + 1).trim();
                System.out.println("------------------" + mandatory);
                final String[] mkeys = mandatory.split(",");
                final ArrayList<String> missingKeys = new ArrayList<>();

                System.out.println("mandatory:" + Arrays.toString(mkeys));
                for (String s : mkeys)
                {
                    if (!templateMap.containsKey(s.trim()))
                    {
                        s = s.trim();
                        missingKeys.add(
                                s.substring(s.indexOf(Constant.OPENING_BRACKET) + Constant.OPENING_BRACKET.length(),
                                        s.indexOf(Constant.CLOSING_BRACKET)));
                    }

                }
                if (!missingKeys.isEmpty())
                {
                    System.out.println(missingKeys);
                }
                else
                {
                    System.out.println("missignkeys are empty");
                }
            }
            else
            {
                System.out.println("not entered mandatory");
            }
            if ((from = br.readLine()).length() > 5)
            {
                from = from.trim().substring(5).trim();
            }

            if ((to = br.readLine()).length() > 3)
            {
                to = to.substring(3).trim();
                if (StringUtils.isBlank(emailobject.getToAddress()))
                {
                    emailobject.setToAddress(to);
                }
                else
                {
                    emailobject.setToAddress(emailobject.getToAddress() + ";" + to);
                }
            }
            System.out.println(to);
            if ((cc = br.readLine()).length() > 3)
            {
                cc = cc.trim().substring(3).trim();
            }
            if ((bcc = br.readLine()).length() > 4)
            {
                bcc = bcc.trim().substring(4).trim();
            }
            if ((subject = br.readLine()).length() > 8)
            {
                subject = subject.trim().substring(8).trim();
            }

            String s;
            final StringBuilder strBuilder = new StringBuilder();
            while ((s = br.readLine()) != null)
            {
                strBuilder.append(s);
                strBuilder.append("\n");
            }
            body = strBuilder.toString();

            for (final Map.Entry<String, String> m : templateMap.entrySet())
            {
                if (subject.contains(m.getKey()))
                {
                    subject = subject.replace(m.getKey(), m.getValue());
                }
                if ((body != null) && body.contains(m.getKey()))
                {
                    body = body.replace(m.getKey(), m.getValue());
                }
            }

            System.out.println(subject);
            System.out.println(body);
            emailobject.setBccAddress(emailobject.getBccAddress() + ";" + bcc);
            emailobject.setCcAddress(emailobject.getCcAddress() + ";" + cc);
            emailobject.setToAddress(emailobject.getToAddress() + ";" + to);
            emailobject.setFromAddress(emailobject.getFromAddress() + ";" + from);
            emailobject.setBody(body);
            emailobject.setSubject(subject);
            return new ResponseEntity<>("success", HttpStatus.CONFLICT);

        }
        catch (final IOException e)
        {
            System.out.println("3");
            e.printStackTrace();
            return new ResponseEntity<>("file not found" + path, HttpStatus.CONFLICT);
        }
        catch (final NullPointerException e1)
        {
            System.out.println("fail");
            e1.printStackTrace();

            return new ResponseEntity<>("file is not in correct format", HttpStatus.CONFLICT);

        }

    }

}
