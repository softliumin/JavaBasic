package cc.sharper.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liumin3 on 2016/2/14.
 */
public class TestRegex
{
    public static void main(String[] args)
    {
//        String text ="This is the text to be searched " + "for occurrences of the http:// pattern.";
//        String pattern = ".*http://.*";
//        boolean matches = Pattern.matches(pattern, text);
//        System.out.println("matches = " + matches);



//        String text ="This is the text to be searched " + "for occurrences of the http:// pattern.";
//        String patternString = ".*http://.*";
//        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(text);
//        boolean matches = matcher.matches();
//        System.out.println("matches = " + matches);




//        String text = "A sep Text sep With sep Many sep Separators";
//        String patternString = "sep";
//        Pattern pattern = Pattern.compile(patternString);
//        String[] split = pattern.split(text);
//        System.out.println("split.length = " + split.length);
//        for(String element : split)
//        {
//            System.out.println("element = " + element);
//        }

//
//        String patternString = "sep";
//        Pattern pattern = Pattern.compile(patternString);
//        String pattern2 = pattern.pattern();
//        System.out.println(pattern2);



//        String text = "John writes about this, and John writes about that," +
//                            " and John writes about everything. ";
//        String patternString1 = "(John)";//括号是必须的
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//
////        System.out.println(matcher.replaceAll("柳敏"));
//
//        while(matcher.find())
//        {
//            System.out.println("found: " + matcher.group(1));
//        }


        //多分组
//        String text = "John writes about this, and John Doe writes about that," + " and John Wayne writes about everything.";
//        String patternString1 = "(John) (.+?) ";
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//        while(matcher.find())
//        {
//            System.out.println("found: " + matcher.group(1) + " " + matcher.group(2));
//        }


        //嵌套分组
//        String text = "John writes about this, and John Doe writes about that," +
//                      " and John Wayne writes about everything.";
//        String patternString1 = "((John)(.+?)) ";//
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//        while(matcher.find())
//        {
//            System.out.println("found: 1： " +  matcher.group(1) + " 2： " + matcher.group(2) + " 3：  " + matcher.group(3));
//        }

        //replaceAll() + replaceFirst() 简单




        //appendReplacement() + appendTail()
        String text = "John writes about this, and John Doe writes about that," +
                      " and John Wayne writes about everything.";

        String patternString1 = "((John) (.+?)) ";
        Pattern      pattern      = Pattern.compile(patternString1);
        Matcher      matcher      = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();

        while(matcher.find())
        {
            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
            System.out.println(stringBuffer.toString());
        }

        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());

//        Joe Blocks
//        Joe Blocks about this, and Joe Blocks
//        Joe Blocks about this, and Joe Blocks writes about that, and Joe Blocks
//        Joe Blocks about this, and Joe Blocks writes about that, and Joe Blocks writes about everything.



    }
}
