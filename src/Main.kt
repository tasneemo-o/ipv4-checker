fun main() {
    val validIp = "192.168.1.1"
    val validIp2 = "0.0.0.0"
    val validIp3 = "255.255.255.255"

    val emptyIp = ""
    val leadingDots  = ".192.168.1.1"
    val trailingDots  = "192.168.1.1."
    val invalidSegmentsCount  = "192.168.1"
    val invalidSegmentsCount2  = "192.168.1.1.12"
    val nonNumericSegment  = "192.%.65.1"
    val emptySegment  = "192.168. .1"
    val invalidOutOfBounds  = "192.168.1.500"
    val invalidWithNegatives  = "-192.168.1.1"
    val leadingZeroes  = "0192.168.1.1"
    val invalidWithConsecutiveDots  = "192.168..1.1"
    val invalidSeparator  = "192-168-1-1"


    checkIpv4(
        name = "a valid ip address",
        result = isValidIpv4(validIp),
        expectedResult = true
    )
    checkIpv4(
        name = "all segments are 0",
        result = isValidIpv4(validIp2),
        expectedResult = true
    )
    checkIpv4(
        name = "all segments are 255",
        result = isValidIpv4(validIp3),
        expectedResult = true
    )
    checkIpv4(
        name = "the ip address cannot be empty",
        result = isValidIpv4(emptyIp),
        expectedResult = false
    )
    checkIpv4(
        name = "the ip address cannot contain leading dots",
        result = isValidIpv4(leadingDots),
        expectedResult = false
    )
    checkIpv4(
        name = "the ip address cannot contain trailing dots",
        result = isValidIpv4(trailingDots),
        expectedResult = false
    )
    checkIpv4(
        name = "the ip address must have exactly 4 segments (no more)",
        result = isValidIpv4(invalidSegmentsCount),
        expectedResult = false
    )
    checkIpv4(
        name = "the ip address must have exactly 4 segments (no less)",
        result = isValidIpv4(invalidSegmentsCount2),
        expectedResult = false
    )
    checkIpv4(
        name = "a segment cannot be empty",
        result = isValidIpv4(emptySegment),
        expectedResult = false
    )
    checkIpv4(
        name = "all segments must be a number",
        result = isValidIpv4(nonNumericSegment),
        expectedResult = false
    )
    checkIpv4(
        name = "every segment must be in the range 1-255 (not greater)",
        result = isValidIpv4(invalidOutOfBounds),
        expectedResult = false
    )
    checkIpv4(
        name = "every segment must be in the range 1-255 (not smaller)",
        result = isValidIpv4(invalidWithNegatives),
        expectedResult = false
    )

    checkIpv4(
        name = "every segment in the ip address cannot start with 0",
        result = isValidIpv4(leadingZeroes),
        expectedResult = false
    )
    checkIpv4(
        name = "no consecutive dots are allowed",
        result = isValidIpv4(invalidWithConsecutiveDots),
        expectedResult = false
    )
    checkIpv4(
        name = "invalid separator: it can be . only",
        result = isValidIpv4(invalidSeparator),
        expectedResult = false
    )
}

fun checkIpv4(name: String, result: Boolean, expectedResult: Boolean) {
    val successColorText = "\u001B[32m"
    val failColorText = "\u001B[31m"
    val resetColor = "\u001B[0m"

    if (result == expectedResult)
        println("$successColorText Pass - $name$resetColor")
    else
        println("$failColorText Fail - $name$resetColor")
}

fun isValidIpv4(ipAddress: String): Boolean {

    return false
}