func twoSum(nums []int, target int) []int {
    m:=make(map[int]int,len(nums))
    for i,v:=range nums{
        comp:=target-v
        if j,ok:=m[comp];ok{
            return []int{j,i}
        }
        m[v]=i
    }
    return []int{}
}
