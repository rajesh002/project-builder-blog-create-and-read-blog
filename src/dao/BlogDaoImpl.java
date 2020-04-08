package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	ConnectionManager con = new ConnectionManager();
	@Override
	public void insertBlog(Blog blog) throws SQLException, Exception {
		System.out.println(blog.getBlogId()+" "+blog.getBlogTitle()+" "+blog.getBlogDescription()+" "+blog.getPostedOn());
		
		String sql = "insert into blog values(?,?,?,?)";
		PreparedStatement st = con.getConnection().prepareStatement(sql);
		st.setInt(1,blog.getBlogId());
		st.setString(2, blog.getBlogTitle());
		st.setString(3, blog.getBlogDescription());
		
		st.setDate(4,Date.valueOf(blog.getPostedOn()));
		st.executeUpdate();
		st.close();
		
	}

	@Override
	public List<Blog> selectAllBlogs() throws Exception {
		List<Blog> list = new ArrayList<Blog>();
		
		Blog blog = null;
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.getConnection();
		
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM blog";
		
		ResultSet rs=stmt.executeQuery(sql);	
		
		while(rs.next()) {
			blog = new Blog();
			blog.setBlogId(rs.getInt("id"));
			blog.setBlogTitle(rs.getString("title"));
			blog.setBlogDescription(rs.getString("description"));
			java.time.LocalDate localDate = rs.getDate("postedOn").toLocalDate();
			blog.setPostedOn(localDate);
			list.add(blog);
		}
		
		System.out.println("I am your data :  "+list);
		
		rs.close();
		stmt.close();
		con.close();
		return list;
	}
	
}