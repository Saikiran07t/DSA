class Solution {
    public List<String> commonChars(String[] words) {
         List<String> result = new ArrayList<>();

        // Create an array to store the count of characters
        int[] charCount = new int[26];

        // Initialize the count array with maximum possible values
        for (int i = 0; i < 26; i++) {
            charCount[i] = Integer.MAX_VALUE;
        }

        // Iterate through each string in the input array
        for (String word : words) {
            int[] currCount = new int[26];

            // Count the frequency of characters in the current string
            for (char c : word.toCharArray()) {
                currCount[c - 'a']++;
            }

            // Update the minimum count for each character
            for (int i = 0; i < 26; i++) {
                charCount[i] = Math.min(charCount[i], currCount[i]);
            }
        }

        // Convert the count array to the result list
        for (int i = 0; i < 26; i++) {
            while (charCount[i] > 0) {
                result.add(Character.toString((char) ('a' + i)));
                charCount[i]--;
            }
        }

        return result;
    }
}