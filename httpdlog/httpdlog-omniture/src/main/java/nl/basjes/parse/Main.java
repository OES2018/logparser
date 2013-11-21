/*
 * Apache HTTPD logparsing made easy
 * Copyright (C) 2013 Niels Basjes
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nl.basjes.parse;

import java.util.List;

import nl.basjes.parse.core.Parser;

public final class Main {


    private Main() {
        // Nothing
    }

    /**
     * @param args
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws MissingDisectorsException
     */
    @SuppressWarnings({ "PMD.SystemPrintln" })
    public static void main(final String[] args) throws Exception {

        String logformat = "%h %l %u %t \"%r\" %>s %b \"%{Referer}i\" \"%{User-Agent}i\"";
//        String logline = "84.105.31.162 - - [05/Sep/2010:11:27:50 +0200] "
//                + "\"GET /fotos/index.html?img=geboorte-kaartje&foo=foofoo&bar=barbar HTTP/1.1\" 200 23617 "
//                + "\"http://www.google.nl/imgres?imgurl=http://daniel_en_sander.basjes.nl/fotos/geboorte-kaartje/"
//                + "geboortekaartje-binnenkant.jpg&imgrefurl=http://daniel_en_sander.basjes.nl/fotos/geboorte-kaartje"
//                + "&usg=__LDxRMkacRs6yLluLcIrwoFsXY6o=&h=521&w=1024&sz=41&hl=nl&start=13&zoom=1&um=1&itbs=1&"
//                + "tbnid=Sqml3uGbjoyBYM:&tbnh=76&tbnw=150&prev=/images%3Fq%3Dbinnenkant%2Bgeboortekaartje%26um%3D1%26hl%3D"
//                + "nl%26sa%3DN%26biw%3D1882%26bih%3D1014%26tbs%3Disch:1\" "
//                + "\"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; nl-nl) AppleWebKit/533.17.8 (KHTML, like Gecko) "
//                + "Version/5.0.1 Safari/533.17.8\"";

        String logline = "2001:980:91c0:1:8d31:a232:25e5:85d - - [05/Sep/2010:11:27:50 +0200] "
                + "\"GET /b/ss/advbolprod2/1/H.22.1/s73176445413647?AQB=1&pccr=true"
                + "&vidn=27F07A1B85012045-4000011500517C43&&ndh=1&t=19%2F5%2F2012%2023%3A51%3A27%202%20-120&ce=UTF-8"
                + "&ns=bol&pageName=%2Fnl%2Fp%2Ffissler-speciaal-pannen-grillpan-28-x-28-cm%2F9200000002876066%2F"
                + "&g=http%3A%2F%2Fwww.bol.com%2Fnl%2Fp%2Ffissler-speciaal-pannen-grillpan-28-x-28-cm%2F9200000002876066"
                + "%2F%3Fpromo%3Dkoken-pannen_303_hs-koken-pannen-afj-120601_B3_product_1_9200000002876066%26bltg.pg_nm"
                + "%3Dkoken-pannen%26bltg.slt_id%3D303%26bltg.slt_nm%3Dhs-koken-pannen-afj-120601%26bltg.slt_p"
                + "&r=http%3A%2F%2Fwww.bol.com%2Fnl%2Fm%2Fkoken-tafelen%2Fkoken-pannen%2FN%2F11766%2Findex.html&cc=EUR"
                + "&ch=D%3Dv3&server=ps316&events=prodView%2Cevent1%2Cevent2%2Cevent31"
                + "&products=%3B9200000002876066%3B%3B%3B%3Bevar3%3Dkth%7Cevar8%3D9200000002876066_Fissler%20Speciaal%20Pannen"
                + "%20-%20Grillpan%20-%2028%20x%2028%20cm%7Cevar35%3D170%7Cevar47%3DKTH%7Cevar9%3DNew%7Cevar40%3Dno%20reviews"
                + "%2C%3B%3B%3B%3Bevent31%3D423&c1=catalog%3Akth%3Aproduct-detail&v1=D%3Dc1&h1=catalog%2Fkth%2Fproduct-detail"
                + "&h2=D%3DpageName&v3=kth&l3=endeca_001-mensen_default%2Cendeca_exact-boeken_default%2C"
                + "endeca_verschijningsjaar_default%2Cendeca_hardgoodscategoriesyn_default%2Cendeca_searchrank-hadoop_default"
                + "%2Cendeca_genre_default%2Cendeca_uitvoering_default&v4=ps316&v6=koken-pannen_303_hs-koken-pannen-afj-120601_B3_"
                + "product_1_9200000002876066&v10=Tu%2023%3A30&v12=logged%20in&v13=New&c25=niet%20ssl&c26=3631"
                + "&c30=84.106.227.113.1323208998208762&v31=2000285551&c45=20120619235127&c46=20120501%204.3.4.1&c47=D%3Ds_vi"
                + "&c49=%2Fnl%2Fcatalog%2Fproduct-detail.jsp&c50=%2Fnl%2Fcatalog%2Fproduct-detail.jsp&v51=www.bol.com&s=1280x800"
                + "&c=24&j=1.7&v=N&k=Y&bw=1280&bh=272&p=Shockwave%20Flash%3B&AQE=1 HTTP/1.1\" 200 23617 "
                + "\"http://www.google.nl/imgres?imgurl=http://daniel_en_sander.basjes.nl/fotos/geboorte-kaartje"
                + "/geboortekaartje-binnenkant.jpg&imgrefurl=http://daniel_en_sander.basjes.nl/fotos/geboorte-kaartje"
                + "&usg=__LDxRMkacRs6yLluLcIrwoFsXY6o=&h=521&w=1024&sz=41&hl=nl&start=13&zoom=1&um=1&itbs=1"
                + "&tbnid=Sqml3uGbjoyBYM:&tbnh=76&tbnw=150&prev=/images%3Fq%3Dbinnenkant%2Bgeboortekaartje%26um%3D1%26hl%3Dnl"
                + "%26sa%3DN%26biw%3D1882%26bih%3D1014%26tbs%3Disch:1\" "
                + "\"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; nl-nl) AppleWebKit/533.17.8 (KHTML, like Gecko) "
                + "Version/5.0.1 Safari/533.17.8\"";

        Parser<MyRecord> parser = new OmnitureLogLineParser<MyRecord>(MyRecord.class, logformat);

        System.out.println("==================================");
        List<String> possiblePaths = parser.getPossiblePaths();
        for (String path: possiblePaths) {
            System.out.println(path);
        }
        System.out.println("==================================");

        MyRecord record = parser.parse(logline);
        System.out.println("INPUT = "+ logline);
        if (record != null) {
            System.out.println("================= \n" + record.toString() + "================= \n");
        }

        String logline2 = "2001:980:91c0:1:8d31:a232:25e5:85d - - [11/Jun/2012:21:34:49 +0200] "
                + "\"GET /portal_javascripts/Plone%20Default/event-registration-cachekey2064.js "
                + "HTTP/1.1\" 200 53614 \"http://niels.basj.es/\" "
                + "\"Mozilla/5.0 (Linux; Android 4.0.3; GT-I9100 Build/IML74K) AppleWebKit/535.19 (KHTML, like Gecko) "
                + "Chrome/18.0.1025.166 Mobile Safari/535.19\"";
        MyRecord record2 = parser.parse(logline2);
        System.out.println("INPUT = "+ logline2);
        if (record != null) {
            System.out.println("RECORD2 = \n" + record2.toString());
        }

    }

}