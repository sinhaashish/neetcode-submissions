func canPartition(nums []int) bool {
    sum :=0 
    for _, v := range nums {
        sum += v
    }
    if sum %2 !=0 {
        return false
    }
    m := len(nums)
    n := sum/2
    dp := make([][]bool, m+1)
    for i := range dp {
        dp[i] = make([]bool, n+1)
    }
    for i:=0 ; i <= m; i++ {
         for j:=0 ; j <= n; j++ {
            if i == 0 { dp[i][j] = false}
            if j == 0 { dp[i][j] = true}
        } 
    } 

    for i:=1 ; i <= m; i++ {
         for j:=1 ; j <= n; j++ {
            if nums[i-1] <= j {
               dp[i][j] = dp[i-1][j- nums[i-1]] || dp[i-1][j]
            } else {
                dp[i][j] = dp[i-1][j]
            }
        } 
    } 
    return dp[m][n]
    
}
