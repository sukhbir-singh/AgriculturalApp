package akssmk.com.agriculturalapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sukhbir on 5/8/16.
 */
public class DataExtractor {
    private String html;
    private ArrayList<NewsItem> newsItems;

    public DataExtractor(String html){
        this.html=html;
        newsItems=new ArrayList<>();

        Document doc= Jsoup.parse(html);

        Elements elements=doc.select("item");
        NewsItem item=null;

        for(int j=0;j<elements.size();j++){
            item=new NewsItem();

            Element element=elements.get(j);

            item.title=element.select("title").html();
            item.pubDate= element.select("pubDate").html();
            item.description= element.select("description").html();
            item.category= element.select("category").html();
            //Log.v("check", element.select("title").html()+"   "+element.select("category").html());

            String ptr="http://news.google.com/news/more?(.*)\"";
            Pattern p=Pattern.compile(ptr);
            Matcher m=p.matcher(element.select("description").html());

            if(m.find()){
                //Log.v("more","http://news.google.com/news/more"+m.group(1).substring(0,m.group(1).length()));
                item.link_more="http://news.google.com/news/more"+m.group(1).substring(0,m.group(1).length());
            }

            ptr="img src=\"(.*)\"";
            p=Pattern.compile(ptr);
            m=p.matcher(element.select("description").html());

            if (m.find()) {
                //Log.v("image_link","https:"+m.group(1).substring(0,m.group(1).indexOf("\"")));
                item.link_image="https:"+m.group(1).substring(0,m.group(1).indexOf("\""));
            }

            ptr="/font&gt;&lt;br&gt;&lt;font size=\"-1\"&gt;(.*)(&amp;nbsp;...&lt;/font&gt;||&amp;nbsp;...&lt;/font&gt;)";

            p=Pattern.compile(ptr);
            m=p.matcher(element.select("description").html());

            if (m.find()) {
                int i1=m.group(1).indexOf("&lt;");
                //Log.v("text description", Jsoup.parse(m.group(1).substring(0,i1)).text().replaceAll("(&#[0-9]+;)|(&nbsp;)",""));
                item.description=Jsoup.parse(m.group(1).substring(0,i1)).text().replaceAll("(&#[0-9]+;)|(&nbsp;)","");
            }

            newsItems.add(item);
        }

    }

    public ArrayList<NewsItem> getNewsItems() {
        return newsItems;
    }
}
