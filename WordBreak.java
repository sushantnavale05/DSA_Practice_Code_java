import java.util.*;

public class WordBreak 
{
    public static boolean wordBreak(String s, List<String> dict)
    {
        Set<String> set = new HashSet<String>(dict);

        for(int i = 0 ; i < dict.size() ; i++)
        {
            set.add(dict.get(i));
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1 ; i <= s.length() ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if(dp[j] && set.contains(s.substring(i,j)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args)
    {
        String s = "Leetcode";
        List<String> dict = Arrays.asList("Leet","code");
        System.out.println(wordBreak(s, dict));
    }
    
    
}
