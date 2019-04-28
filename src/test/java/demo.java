import org.testng.annotations.Test;

/**
 * @created by iask on 2019-04-28 21:05
 **/
public class demo {

    /**
     *  AES 解密加密 测试
     * @throws Exception
     */
    @Test
    public void testAES () throws Exception {

        String appKey = "hdkj";// appKey
        String secret = "sd6FSsbyvxw1f";
        String content = "[{\"customerName\":\"齐天大圣\",\"customerMobile\":\"1810201123\",\"houseType\":1,\"carType\":2,\"money\":1000000,\"month\":12,\"zoneId\":10086,\"age\":30,\"salaryBankPublic\":5100000,\"salaryBankPrivate\":1,\"isFund\":1,\"isSecurity\":1,\"creditCard\":2,\"isBuyInsurance\":1,\"weixinLoanAmount\":4100000,\"alipayLoanAmount\":0},{\"customerName\":\"美猴王\",\"customerMobile\":\"1810200123\",\"houseType\":1,\"carType\":1,\"money\":2000000,\"month\":12,\"zoneId\":10086,\"age\":30,\"salaryBankPublic\":5100000,\"salaryBankPrivate\":1,\"isFund\":1,\"isSecurity\":1,\"creditCard\":2,\"isBuyInsurance\":1,\"weixinLoanAmount\":4100000,\"alipayLoanAmount\":0},{\"customerName\":\"斗战胜佛\",\"customerMobile\":\"1340200123\",\"houseType\":1,\"carType\":0,\"money\":3000000,\"month\":12,\"zoneId\":10086,\"age\":30,\"salaryBankPublic\":5100000,\"salaryBankPrivate\":1,\"isFund\":1,\"isSecurity\":1,\"creditCard\":2,\"isBuyInsurance\":1,\"weixinLoanAmount\":4100000,\"alipayLoanAmount\":0}]";

        System.out.println("明文:" + content);
        //加密
        String encryptResult = AES256.encrypt(content, secret);
        System.out.println("密文:" + encryptResult);
        String decryptResult = AES256.decrypt(encryptResult, secret);
        System.out.println("解密:" + decryptResult);

    }


    /**
     * 测试 数据推送接口
     */
    @Test
    public void testApi() {

        String url = "http://47.111.185.141/data/api/push";
        String content  = "{\"appKey\":\"hdkj\",\"data\":\"opsuqnlHVaWGMV/p9oI4szBe2SHprsEwAJCWbijX/lP/8vVVSdCOZf0aykETl+9Z1YtOdXgaadsPR0/W1cEFeL8zcsOJ/TDHKip4WAodYDC6K56sNWNijqGVaTNI5PhIWj+F+fPinnw+zfCF6DoArxJ4RiImJMTYntLJSZAvNgQYXckvYny+RwSZ+nrTW5L8GBRFPAl6jkzjka2ojOV61neJxDAn8UbizkYQti4yzryU29rnZnnRRIbiOM6cilZ+pWN8zyndoWYHXVF7xGZ6KDmC1s643fnpp27yeObztMZZ0ZBzQL+1CtmbAST99V3UsrvT/2NOGUGNSL8+7232rDrQ92vCHPhtM6n8xG0jK0GHcSE40+NNMWZEOxU92VPBYxe0bk/LByEZuWAEZXjRywq7jnghhc97Wylep5cDvvq2b1KEo6usZhP4FZoXAtnBELzAYzmvElqMOpGrJTMjp7qtZW483Q+0UTtfXDQkewqMjOgHnv8j09QhyOrBL+o3sV3ZsHg/GGJGDWuxYJDRSfzClPmEPdbEsnOZDiORKk1bH7mz98eExPIteTlCFjtZ0M2x0j29KOJ2w8UqPoWQkCnIXg9IoM8pm1gHX9NztV0AuW091BL3wm5kkhAdSf6Vph87ND7WLgEa9Re2LWlUW/HPVyEJuqKuKiq5x/Mlt6r/i+DFltLh9TqJbtKYkererrEbe0nTWjUa27dc9K2IgElwWKG1rL18YxxhtY6G+XuAOIBjiomOxRG3yBgYYtBp3f9KHyEu9ieRMq5BMjl38D24QOkKr+K0RI1i64OxxEwDaphBGpiv7Hp+fKSZCuf0ek+/INhrPVQkut1ie14msGUtoowF2nG6/kdXVEDM1kVi8LdW574duHlB8BdpvA8H97ItCoMgJD+ntWjyEeRNrpe6BU/i0hbbu9DBoA5UxXjzZrq7lo9N76UVLpCswd7l64JlT21FCHvwtEd2yYfzPmJpwE5UI84asj8v0xt7fKMqi8c+hUFkI+YuXxhFhGD05cIZ/42Ykj46JWTdoCl12Ib8/rq7mCYl9QV4M4PmH9LxBohfNXbffXQU2JjCCK7c3xvUzIOPIvN1cN0qc0A2ReLzyapx7fvfVSui3cYdmDtUM+vq19UmLZlyyk0YiiEA5Bz3XEgae8qyFumFawpozBKXTG3T+xyqiUVrc1s3QDc=\"}";
        String res = HttpUtils.sendPost(url, content);
        System.out.println("返回结果："+res);
    }
}
