class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        Stack<Temp> st = new Stack();
        for (int  i =0 ; i < temperatures.length ; i++) {
            int temperature = temperatures[i];
            while ( !st.isEmpty() && temperature > st.peek().data) {
                Temp t = st.pop();
                res[t.index]=i-t.index;
            }
            st.push(new Temp(temperature, i));
        }
        return res;
    }
}

public class  Temp{
    int data; 
    int index;
    public Temp(int data, int index) {
        this.data = data;
        this.index = index;
    }

}
