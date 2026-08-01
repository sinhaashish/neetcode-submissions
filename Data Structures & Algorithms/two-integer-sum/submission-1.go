func twoSum(nums []int, target int) []int {
	hs := make(map[int]int)
	for i:=0 ; i < len(nums); i++ {
		if index, ok := hs[target- nums[i]] ; ok {
			return []int{ index, i  }
		}
		hs[nums[i]] = i
	}  
	return nil
}
