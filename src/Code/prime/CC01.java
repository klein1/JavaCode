package Code.prime;

public class CC01 {

    public boolean isUnique(String astr) {
        long mark = 0L;
        char[] arr = astr.toCharArray();

        for(char c : arr){
            long temp = 1L << (c - 'a');
            if((temp & mark) != 0)
                return false;
            else
                mark |= temp;
        }

        return true;

    }
}
