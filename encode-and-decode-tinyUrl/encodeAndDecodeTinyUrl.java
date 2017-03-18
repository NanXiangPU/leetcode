public class Codec {
    private String letters = "abcdefghijklmnopqretuvwxyz0123456789";
    private Map<String, String> hashmap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    private String generateShort() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 6; ++i) {
            char tmp = letters.charAt(random.nextInt(letters.length()));
            sb.append(tmp);
        }
        return sb.toString();
    }
    
    public String encode(String longUrl) {
        String shortUrl = generateShort();
        while(hashmap.containsKey(shortUrl)) {
            shortUrl = generateShort();
        }
        String part = longUrl.substring(0, longUrl.indexOf("/", 2) + 1);
        hashmap.put(part + shortUrl, longUrl);
        return part + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hashmap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));