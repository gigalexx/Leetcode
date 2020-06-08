package problems.easy


fun main() {
    numUniqueEmails(arrayListOf("test.email+alex@leetcode.com", "test.e.mail.+bob.cathy@leet.code.com"))
}

fun numUniqueEmails(emails: ArrayList<String>): Int {

    var set = mutableSetOf<String>()
    val builder = StringBuilder()
    for (email in emails) {

        builder.clear()
        val split = email.split("@")
        val domain = split[1]

        for (char in split[0]) {
            if (char == '.') continue
            else if (char == '+') break
            builder.append(char)
        }


        builder.append("@").append(domain)

        set.add(builder.toString())
    }
    return set.size
}
