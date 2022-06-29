import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedList;
import java.util.Queue;

/*
* 535. TinyURL 的加密与解密
* */
public class leetcode535 {

    public class Codec {

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            Base64.Encoder encoder = Base64.getUrlEncoder();
            return encoder.encodeToString(longUrl.getBytes(StandardCharsets.UTF_8));
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            Base64.Decoder decoder = Base64.getUrlDecoder();
            byte[] decode = decoder.decode(shortUrl);
            StringBuilder ans = new StringBuilder();
            for (byte b : decode) {
                ans.append((char) b);
            }
            return ans.toString();
        }
    }
    //官方
//    public class Codec {
//        private Map<Integer, String> dataBase = new HashMap<Integer, String>();
//        private Random random = new Random();
//
//        public String encode(String longUrl) {
//            int key;
//            while (true) {
//                key = random.nextInt();
//                if (!dataBase.containsKey(key)) {
//                    break;
//                }
//            }
//            dataBase.put(key, longUrl);
//            return "http://tinyurl.com/" + key;
//        }
//
//        public String decode(String shortUrl) {
//            int p = shortUrl.lastIndexOf('/') + 1;
//            int key = Integer.parseInt(shortUrl.substring(p));
//            return dataBase.get(key);
//        }
//    }
}
