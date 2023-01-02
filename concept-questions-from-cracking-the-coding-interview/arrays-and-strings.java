public class chapterOne {

    //determine if string has all unique characters only using arrays/lists & hashtables
    public boolean isUnique(String s){
        //O(n)
        boolean[] alpha = new boolean[128];
        //has the current character appeared more than once from the alphabet?
        for(char c : s.toCharArray()){
            if(alpha[int(c)]){
                return false;
            }
            alpha[int(c)] = true;
        }
    }

    //check if string a is a permutation of string b
    public boolean isPermutation(String a, String b){
        if(a.length != b.length){
            return false;
        }
        return Arrays.sort(a.toCharArray()).equals(Arrays.sort(b.toCharArray()));
    }

    public String URLify(char[] str){
        int spaceCount = 0, newLength;
        for(int i = 0; i < length; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + spaceCount * 2;
        str[newLength] = '\0';
        for(int i = length - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
    }
}