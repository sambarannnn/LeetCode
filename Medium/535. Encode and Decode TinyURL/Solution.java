public class Codec {

    private String base = "http://tinyurl.com/";
    private String dump = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    HashMap<String, String> LongToTiny = new HashMap<String, String>();
    HashMap<String, String> TinyToLong = new HashMap<String, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(LongToTiny.containsKey(longUrl)) {
            return LongToTiny.get(longUrl);
        }
        String tinyUrl = generateTiny();
        while(TinyToLong.containsKey(tinyUrl)) {
            tinyUrl = generateTiny();
        }
        TinyToLong.put(tinyUrl, longUrl);
        LongToTiny.put(longUrl, tinyUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(TinyToLong.containsKey(shortUrl)) {
            return TinyToLong.get(shortUrl);
        } else {
            return "NA";
        }
    }
    public String generateTiny() {
        Random rand = new Random();
// nextInt as provided by Random is exclusive of the top value so you need to add 1 
        // int randomNum = rand.nextInt((max - min) + 1) + min; min and max inclusive

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            int randomIndex = rand.nextInt(dump.length());
            sb.append(dump.charAt(randomIndex));
        }
        return base + sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
