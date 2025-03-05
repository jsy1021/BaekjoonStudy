class Solution {
    public int solution(int[] num_list) {
    StringBuilder odd_sum = new StringBuilder();
    StringBuilder even_sum = new StringBuilder();

    for (int num : num_list) {
        if (num % 2 == 0) {
            even_sum.append(num);
        } else {
            odd_sum.append(num);
        }
    }

    int evenNum = Integer.parseInt(even_sum.toString());
    int oddNum = Integer.parseInt(odd_sum.toString());

    return evenNum + oddNum;
}
}