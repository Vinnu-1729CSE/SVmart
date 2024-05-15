package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Jdbccon;
import model.ProductCatagory;

public class Dataaccesspctg {
	private ArrayList<ProductCatagory> pcatlist = new ArrayList<ProductCatagory>();

	public ArrayList<ProductCatagory> getPcatlist() {
		rundta();
		return pcatlist;
	}

	public void setPcatllist(ArrayList<ProductCatagory> pcatlist) {
		this.pcatlist = pcatlist;
	}

	public void rundta() {

		System.out.println("pcatrunning");

		Jdbccon jconnect = new Jdbccon();
		Connection con = jconnect.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT pcatid, pcatname FROM public.ashish_pcategory;");
			ResultSet rs = ps.executeQuery();
			System.out.println("connection returned and resultset executed");
			while (rs.next()) {
				pcatlist.add(new ProductCatagory(rs.getInt("pcatid"), rs.getString("pcatname")));
			}
			System.out.println("this is list");
			System.out.println(pcatlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}