int removeDuplicates(int* nums, int numsSize) {
    if (nums == NULL) {
        return 0;
    }
    if (numsSize < 2) {
        return numsSize;
    }
    int size = 1;
    for (int i = 1; i < numsSize; ++i) {
        if (nums[i] == nums[i - 1]) {
            continue;
        }
        nums[size++] = nums[i];
    }
    return size;
}