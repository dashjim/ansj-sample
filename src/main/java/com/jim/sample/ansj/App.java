package com.jim.sample.ansj;

import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * ANSJ https://github.com/NLPchina/ansj_seg 4500+ stars on Github.
     *
     * It clams the fllowing:
     *
     * accuracy is above 96%.
     * based on n-Gram+CRF+HMM
     * process 200 million Chinese characters one second on a laptop.
     *
     * Default dictionary is wrapped inside its jar.
     *
     * @param args
     */
    public static void main( String[] args )
    {
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        System.out.println(ToAnalysis.parse(str));
        System.out.println(ToAnalysis.parse(str).toStringWithOutNature());

        // Simple tokenizer
        System.out.println(ToAnalysis.parse(str).toStringWithOutNature(" "));


        // Stop words - not recommend for some model.
        StopRecognition filter = new StopRecognition();

        filter.insertStopNatures("d"); // filter out the nature
        filter.insertStopNatures("null");
        filter.insertStopWords("我"); // filter out the word.
        filter.insertStopWords("在"); // filter out the word.
        filter.insertStopRegexes("帮.*?"); //支持正则表达式
        System.out.println(ToAnalysis.parse(str).recognition(filter).toStringWithOutNature(" "));

        // TODO It also supports the user defined dictionary. I used that before, but it requires a little more config.
        // TODO basically, the user defined entities in AVA and names like 亚美亚 or similar should be put to custom dictionary.
        // TODO If some words are not parsed correctly we can also put these words to custom dictionary.

        // It also has other features, please let me know if you need anything specific.
    }
}
