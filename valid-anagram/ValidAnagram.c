bool isAnagram(char* s, char* t) {
    char hS[26] = {0}, hT[26] = {0};
    while(*s && *t)  (hS[*(s++) -'a'])++, (hT[*(t++) -'a'])++;
    return (!*s && !*t && !memcmp(hS, hT, 26));
}