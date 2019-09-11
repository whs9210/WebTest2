package db연결연습;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {

	public void insert(ProductDTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/product";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String insert = "insert into product1 values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);

		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getPrice());

		ps.executeUpdate();

	}

	public ProductDTO select(String sid) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/product";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String select = "select * from product1 where id = ?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setString(1, sid);

		ResultSet rs = ps.executeQuery();
		ProductDTO dto = new ProductDTO();

		if (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String content = rs.getString(3);
			String price = rs.getString(4);

			dto.setId(id);
			dto.setName(name);
			dto.setContent(content);
			dto.setPrice(price);

		}
		return dto;

	}

}
