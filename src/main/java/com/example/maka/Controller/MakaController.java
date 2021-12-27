package com.example.maka.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.example.maka.Service.MakaService;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.joda.time.DateTime;
import java.util.Date;
import java.util.HashMap;
/**
 * @author Administrator
 */
@RestController
@RequestMapping("maka")
public class MakaController {

    @Value("${name.value}")
    private String value;

    @PostMapping("/getCode")
    public void getCode() throws Exception {
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiwv46ReCEFB5tIEB6YRhJ1GN3SrE0LPYnmCAFU39N85gCZaEaj5lNdxggy3X0xtxCxK0SU29Zp4XMfzRBi2IA87rDc5shKQ9Q3l79WWOKEelCSIc2fUpxPNrKAtvHZVJnHNvfB7K8Hbu0PNX2YZ8NYEzFVnyOUB63/kqKt8PIrP4np/wEhhTmGV65Z10JBHEFtPPwjU88zz5qMiQw8kjhlfW2dAYKVU2/xovvAZylj58TvzZu6aoubgwJNIn/lBWFG0pSv3af5IMdSe3g9IR1Mg11LtPa+VHh8hSiftgbhSg+fbOmd2rO79e5z+vGqbGbGqKXLYJQNxNCn0eVinhbwIDAQAB";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCLC/jpF4IQUHm0gQHphGEnUY3dKsTQs9ieYIAVTf03zmAJloRqPmU13GCDLdfTG3ELErRJTb1mnhcx/NEGLYgDzusNzmyEpD1DeXv1ZY4oR6UJIhzZ9SnE82soC28dlUmcc298Hsrwdu7Q81fZhnw1gTMVWfI5QHrf+Soq3w8is/ien/ASGFOYZXrlnXQkEcQW08/CNTzzPPmoyJDDySOGV9bZ0BgpVTb/Gi+8BnKWPnxO/Nm7pqi5uDAk0if+UFYUbSlK/dp/kgx1J7eD0hHUyDXUu09r5UeHyFKJ+2BuFKD59s6Z3as7v17nP68apsZsaopctglA3E0KfR5WKeFvAgMBAAECggEAPZKOpcFoMgtA6aKbEyowz3V4ybBvuS96xB9deJGxiO3Vb0l814NL1D8DafN5+BzVwR6GQVOwhGmLQfJ/KSouaelOAy4etdn42xFHyBIxkjqvpUy60/WRiop0MCZoDQSXtTUU8DS+jx9Lf7HSfBvmktbkpRbQgXPBNb8jYhqmnCnHDIH0tC9VXVgfKZkZGjZQAbpiCysvaIXh+LJD309e3Oh3CDcnTvdUSgo2teTfduXL/2XfD31VEMvK5nZe5Lv1ReeeVrz6db9ffJvbJQt5rOBWhstdMNPd3ZbL3/fl7JZMg9zbokyCXzhaHOKYvpStkc//DDrsaCTC4mGCw44JyQKBgQDam2ZOu35Ygg1wn/hnb1j6VUEJTrlcCPpSLqczooMa9xm4QLy9qrvQH3ncExxUTsx6+xnPZt9WDaBZe7JeGJtJvyFmZroObRu2rAnLxZ6RJUI51h9rrLSXeGaPTMaibC3dwRkWrW1xfGE6+gDZ0anCutxy/bMOQ+/2xLrMl7xVswKBgQCi1LO7PG/+8eq5LmYInDQ9JViyzSrA9V0ayF0LAiQz3oHOG3pNE5DlXcPVlhgAw+/FGohYd1YrJLBgmrL53bUr7pL0fXf2xyg66plgLwTSyAvTKPpmbCEYNTyTw/XtasZRO7HEUOSWwrjjz+rik7xGOkCN34Tktr/DY7QbadxfVQKBgFjC1E2Pj4N8etyJ96B385bhWuDemCCofIs16inrCHTAdC7+CiSw2EVvIlmbYNtSi3A72IT/7hrQuZTbxtayAwt0kak0eMM2xhPr0qZsfS/OAw/cwzFDFKiT+ICi2dxFNHJf30H39QIpUIlTzVij6tvoZ25BWJyoNRzrUDWWPqBFAoGAIDPSq8fjGld7pU3gzfked61IImxi9TBRTnertv6gbEWoBDv47v9cm4/0p+v8KUKWy7NYna5UM0oZO7G8jZ/kMaEIHSQnMn3mnehBlv0Vhh4cAJHNG65syR3WMh8CJwcD25LjsECTRKGT8THwcQjopjblB2naHWVq/VhdiUJhW9UCgYEA0FtRX1Hm7Yne46AD/YeNa82hlHSvVEG3weTQXi1JSguJi+doYh+LLgS1SEkBCrn5zTIHTSXR1mBJLQnL47JXz6tfOnEeBvhFpmmVg3scdJIO7e8hu7J531QId8L542aCHzxGaVKp+pOqdXK+TBBRFu6bbeAftGAIXZ7Pt/9g34o";
        String message = "df723820";
        String messageEn = RSAEncrypt.encrypt(message,publicKey);
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = RSAEncrypt.decrypt(messageEn,privateKey);
        System.out.println("还原后的字符串为:" + messageDe);
    }

}
