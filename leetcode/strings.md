# String


+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome][#valid-palindrome]
+ [Longest Palindromic Substring][#longest-palindromic-substring]

## Group Anagrams

https://leetcode.com/problems/group-anagrams/

```
class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList();
            Map<String, List> ans = new HashMap<String, List>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) count[c - 'a']++;

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
```

## Valid Palindrome

https://leetcode.com/problems/valid-palindrome/
```
 class Solution {
        public static boolean isPalindrome(String s) {
            if(s==null){
                return false;
            }

            s = s.toLowerCase();

            int i=0;
            int j=s.length()-1;

            while(i<j){
                while(i<j && !((s.charAt(i)>='a' && s.charAt(i)<='z')
                        || (s.charAt(i)>='0'&&s.charAt(i)<='9'))){
                    i++;
                }

                while(i<j && !((s.charAt(j)>='a' && s.charAt(j)<='z')
                        || (s.charAt(j)>='0'&&s.charAt(j)<='9'))){
                    j--;
                }

                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }

                i++;
                j--;
            }

            return true;
        }
        }
```

## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/
```
class Solution {
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
    }
}
```
