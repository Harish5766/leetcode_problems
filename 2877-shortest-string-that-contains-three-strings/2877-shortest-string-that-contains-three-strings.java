class Solution {
    public String minimumString(String a, String b, String c) {
        List<String> result = new ArrayList<>();
        result.add(get(a, b, c));
        result.add(get(a, c, b));
        result.add(get(b, a, c));
        result.add(get(b, c, a));
        result.add(get(c, a, b));
        result.add(get(c, b, a));
        String min = result.get(0);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length() > min.length()) {
               continue;
            }
            
            if (result.get(i).length() < min.length()) {
                min = result.get(i);
               continue;
            }
            
            if (result.get(i).compareTo(min) < 0) {
                min = result.get(i);
            }
        }
                
        return min;
    }
    
    private String get(String a, String b, String c) {
        String ab = getTwo(a, b);
        return getTwo(ab, c);
    }
    
    private String getTwo(String a, String b) {
        if (a.contains(b)) {
            return a;
        }
        
        int size = Math.min(a.length(), b.length());
        
        for (int i = size; i >= 0; i--) {
            if (a.substring(a.length() - i).equals(b.substring(0, i))) {
                return a + b.substring(i);
            }
        }
        
        return a + b;
    }
}