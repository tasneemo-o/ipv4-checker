fun main() {
    val standardValidIp = "192.168.1.1"
    val allZerosIp = "0.0.0.0"
    val allMaxValuesIp = "255.255.255.255"

    val emptyIp = ""
    val ipWithLeadingDot = ".192.168.1.1"
    val ipWithTrailingDot = "192.168.1.1."
    val fewSegmentsIp = "192.168.1"
    val manySegmentsIp = "192.168.1.1.12"
    val ipWithNonNumericSegment = "192.%.65.1"
    val ipWithEmptySegment = "192.168. .1"
    val ipWithLargeSegment = "192.168.1.500"
    val ipWithNegativeSegment = "-192.168.1.1"
    val ipWithLeadingZeroes = "0192.168.1.1"
    val ipWithConsecutiveDots = "192.168..1.1"
    val ipWithInvalidSeparator = "192-168-1-1"


    checkIpv4(
        name = "should accept standard valid IP address",
        result = isValidIpv4(standardValidIp),
        expectedResult = true
    )
    checkIpv4(
        name = "should accept IP with all zeros",
        result = isValidIpv4(allZerosIp),
        expectedResult = true
    )
    checkIpv4(
        name = "should accept IP with all 255",
        result = isValidIpv4(allMaxValuesIp),
        expectedResult = true
    )
    checkIpv4(
        name = "should reject empty IP address",
        result = isValidIpv4(emptyIp),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with leading dot",
        result = isValidIpv4(ipWithLeadingDot),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with trailing dot",
        result = isValidIpv4(ipWithTrailingDot),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with fewer than 4 segments",
        result = isValidIpv4(fewSegmentsIp),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with more than 4 segments",
        result = isValidIpv4(manySegmentsIp),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with empty segment",
        result = isValidIpv4(ipWithEmptySegment),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with non-numeric segment",
        result = isValidIpv4(ipWithNonNumericSegment),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with segment value greater than 255",
        result = isValidIpv4(ipWithLargeSegment),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with negative segment value",
        result = isValidIpv4(ipWithNegativeSegment),
        expectedResult = false
    )

    checkIpv4(
        name = "should reject IP with leading zeros in segment",
        result = isValidIpv4(ipWithLeadingZeroes),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with consecutive dots",
        result = isValidIpv4(ipWithConsecutiveDots),
        expectedResult = false
    )
    checkIpv4(
        name = "should reject IP with invalid separators",
        result = isValidIpv4(ipWithInvalidSeparator),
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

    // check for the ip string is empty
    if (ipAddress.isEmpty()) {
        return false
    }

    // check for leading or trailing dots
    if (ipAddress.startsWith('.') || ipAddress.endsWith('.')) {
        return false
    }

    // check for consecutive dots
    // this case is already handled when checking for the number of segments,
    if (ipAddress.contains("..")) {
        return false
    }

    // if the number of segments is not exactly 4
    val segments = ipAddress.split(".")
    if (segments.size != 4) {
        return false
    }


    for (segment in segments) {

        // check if the segment is not a number or not in the range (0-255)
        val segmentValue = segment.toIntOrNull()
        if (segmentValue == null) {
            return false
        } else if (segmentValue < 0 || segmentValue > 255) {
            return false
        }

        // check for leading or trailing zeros
        if (segment != "0" && segment.startsWith('0')) {
            return false
        }
    }

    // check for the non-dot separator (ex: 192-168-1-1)
    // this case is also handled when checking for the number of segments,
    // as it splits using '.', it will not count any segments


    return true
}