import com.wen.dao.BlogMapper;
import com.wen.pojo.Blog;
import com.wen.util.IDutil;
import com.wen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class BlogMapperTest {
    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        Blog blig = mapper.getBlig("001");
//        System.out.println(blig);

        Blog blog = new Blog();
        blog.setId(IDutil.getId());
        blog.setTitle("python基础");
        blog.setAuthor("温彬");
        blog.setCreateTime(new Date());
        blog.setViews(12366);

        int i = mapper.addBlog(blog);

        blog.setId(IDutil.getId());
        blog.setTitle("航空英语");
        blog.setAuthor("李轩");
        mapper.addBlog(blog);

        blog.setId(IDutil.getId());
        blog.setTitle("商务礼仪");
        blog.setAuthor("李轩");
        mapper.addBlog(blog);

        blog.setId(IDutil.getId());
        blog.setTitle("网络安全");
        blog.setAuthor("温彬");
        mapper.addBlog(blog);

        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();
    }
}
