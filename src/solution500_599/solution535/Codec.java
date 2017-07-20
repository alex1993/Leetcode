package solution500_599.solution535;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/21.
 */
public class Codec {
    List<String> strings = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        strings.add(longUrl);
        return String.valueOf(strings.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return  strings.get(Integer.valueOf(shortUrl));
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
