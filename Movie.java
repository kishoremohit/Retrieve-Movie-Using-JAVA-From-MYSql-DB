import java.sql.*;
import java.sql.DriverManager;

class Director {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select Director from moviee where Title=? ");

	pst.setString(1,"A Walk to Remember");
	pst.execute();
	ResultSet rs=pst.getResultSet();
	
	
	while(rs.next()) {
		String Director=rs.getString(1);
		Thread.sleep(500);
		System.out.println("\n\t------------------------------------------------------");
	    System.out.println("\n\tDirector Of Movie 'A Walk to Remember' : "+Director);
	    System.out.println("\n\t------------------------------------------------------");
	}
	
	}
}


class Doc {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select * from moviee where MovieType=?");

	pst.setString(1, "Documentary");
	
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t------------------");
	System.out.println("\n\t\tDocumentary Movies");
	System.out.println("\n\t\t------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(1));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}

class D {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select * from moviee where MovieType=? and MovieYear=?");

	pst.setString(1, "Documentary");
	pst.setString(2, "2000");
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t-------------------------");
	System.out.println("\n\t\tDocumentary Movies : 2000");
	System.out.println("\n\t\t-------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(1));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}


class Steven {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select * from moviee where Director=?");

	pst.setString(1, "Steven Spielberg");
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t----------------------------------");
	System.out.println("\n\t\tMovie Directed By Steven Spielberg");
	System.out.println("\n\t\t----------------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(1));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}

class S {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select * from moviee where Director=? and  MovieYear=?");

	pst.setString(1, "Steven Spielberg");
	pst.setString(2, "2012");
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t--------------------------------------------");
	System.out.println("\n\t\tMovie Directed By Steven Spielberg In '2012'");
	System.out.println("\n\t\t--------------------------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(1));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}

class Max {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("(select *,count(?) from moviee group by MovieYear);");

	pst.setString(1, "MovieYear");
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t--------------------------------");
	System.out.println("\n\t\tNumber Of Movie Released In Year");
	System.out.println("\n\t\t--------------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(6)+"\t"+rs.getString(12));
	    Thread.sleep(200);
	    System.out.println();
	}
	
	}
}

class Romance {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select * from moviee where Genre=?");

	pst.setString(1, "romance");
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t----------------------------------");
	System.out.println("\n\t\t Movies Belongs To Genre 'Romance'");
	System.out.println("\n\t\t----------------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(1));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}

class Vote {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select Title,Vote,Genre From moviee where Genre=? ORDER BY Vote desc limit 3;");

	pst.setString(1, "romance");
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t---------------------------------------------------------------------------");
	System.out.println("\n\t\tTop 3 Movies with Genre 'Romance' Which Got Highest Number of Votes on IMDb");
	System.out.println("\n\t\t---------------------------------------------------------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}


class Runtime {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	PreparedStatement pst=con.prepareStatement("select Title,MAX(Runtime),Genre from moviee where Genre=? and MovieYear>='2005';");

	pst.setString(1, "thriller");
	pst.executeQuery();
	ResultSet rs=pst.getResultSet();
	System.out.println("\n\t\t------------------------------------------------------------------------");
	System.out.println("\n\t\tMovie With Genre 'Thriller' Have Highest Runtime And Released After 2005 ");
	System.out.println("\n\t\t------------------------------------------------------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}

class AVG {
	void display() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false","root","13158920");
	Statement pst=con.createStatement();

	pst=con.createStatement();
	ResultSet rs=pst.executeQuery("select AVG(Rating) from moviee;");
	
	System.out.println("\n\t\t ------------------------------");
	System.out.println("\n\t\t Average IMDb Rating For Movies");
	System.out.println("\n\t\t ------------------------------");
	while(rs.next()) {
	    System.out.println("\n\t\tAverage : "+rs.getString(1));
	    Thread.sleep(500);
	    System.out.println();
	}
	
	}
}


public class Movie {

	public static void main(String[] args) throws Exception {
	
	Director obj=new Director();
	obj.display();
	Thread.sleep(2000);
	Doc o=new Doc();
	o.display();
	Thread.sleep(1000);
	D i=new D();
	i.display();
	Thread.sleep(1000);
	Steven ob=new Steven();
	ob.display();
	S s=new S();
	s.display();
	Max m=new Max();
	m.display();
	Romance r=new Romance();
	r.display();
	Vote v=new Vote();
	v.display();
	Runtime ru=new Runtime();
	ru.display();
	AVG a=new AVG();
	a.display();
	}
}