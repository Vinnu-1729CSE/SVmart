package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jdbccon;
import model.Product;

public class DataAccessCatagoryWiseProduct {
	private List<Product> productList = new ArrayList<Product>();

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void rundta(Integer selectedpcat) {
		System.out.println("running dacwp");
		Jdbccon jconnect = new Jdbccon();
		Connection con = jconnect.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT pid, pname, price, hsn_code, pcatid, image	FROM public.ashish_products where pcatid=?; ");
			ps.setInt(1, selectedpcat);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				productList.add(new Product(rs.getInt("pid"), rs.getString("pname"), rs.getDouble("price"),
						rs.getString("hsn_code"), rs.getInt("pcatid"), rs.getString("image")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}