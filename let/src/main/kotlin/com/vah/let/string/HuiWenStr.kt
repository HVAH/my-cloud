package com.vah.let.string;

/**
 *@Description  中心扩展法
 *@Author HuangJiang
 **/
fun expand(s: String): String {
    if (s.isBlank() || s.length == 1) return s
    var b = 0
    var end = 0
    for (i in s.indices) {
        val len1 = expandLength(s, i, i)
        val len2 = expandLength(s, i, i + 1)
        val len = len1.coerceAtLeast(len2)
        if (len > end - b) {
            b = i - (len - 1) / 2
            end = i + len / 2
        }
        println("i=$i len1=$len1 len2=$len2 b=$b end=$end")
    }
    return s.substring(b, end + 1)
}

/**
 * 扩展长度
 */
fun expandLength(s: String, l: Int, r: Int): Int {
    var ll = l
    var rr = r
    while (true) {
        if (ll >= 0 && rr < s.length && s[ll] == s[rr]) {
            ll--
            rr++
        } else {
            return rr - ll - 1
        }
    }
}

fun baoli(s: String) {

}

fun isHuiWenStr(s: String) {
    for (i in s.indices) {

    }
}

fun main() {
    println(expand("aaaaaa"))
}
