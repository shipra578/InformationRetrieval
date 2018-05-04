import opennlp.tools.tokenize.SimpleTokenizer;

public class OpenNLPTokenizer {

    public String[] tokenize(String sentence) {
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String tokens[] = tokenizer.tokenize(sentence);

        for(String token : tokens)
            System.out.println(token);

        return tokens;
    }
}
