package com.java.circle.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.circle.dto.CDto;
import com.java.circle.dto.CDtoCircle;

public class CDao {

	ConnectionMaker connectionMaker;
	
	public CDao(){
		connectionMaker = new ConnectionMaker();
	}
	
	public ArrayList<CDto> showList(){
		ArrayList<CDto> dtos= new ArrayList<CDto>();
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet resultSet = null;
		
		try{

			String query = "select user_id, account, password, name, auth_id, univ_id from cUser order by user_id desc";
			conn = connectionMaker.getConnection();			
			pstmt = conn.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()){
				
				System.out.println("here something!");
				int user_id = resultSet.getInt("user_id");
				String account = resultSet.getString("account");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				int auth_id = resultSet.getInt("auth_id");

				int univ_id = resultSet.getInt("univ_id");

				CDto dto = new CDto(user_id, account, password, name, auth_id, univ_id);
				dtos.add(dto);  
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			
			connectionMaker.closeConnection(conn);
			
			try{
				
				if(resultSet != null)resultSet.close();
				if(pstmt != null)pstmt.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public void signup(HashMap<String,String> param){
		
		Connection conn = null;
		PreparedStatement pstm = null;
		conn = connectionMaker.getConnection();
		try {

			String query = "insert into cUser (account, password, name, auth_id, univ_id) values (?,?,?,?,?)";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, param.get("account").toString());
			pstm.setString(2, param.get("password").toString());
			pstm.setString(3, param.get("name").toString());
			pstm.setInt(4, Integer.parseInt(param.get("auth").toString()));
			pstm.setInt(5, Integer.parseInt(param.get("univ").toString()));
		
			int n = pstm.executeUpdate();
			
			System.out.println("쿼리결과:" + n);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(pstm!=null)
						pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				connectionMaker.closeConnection(conn);
		}

	}
	
	public int checkSignin(String account, String password){

		Connection conn = null;
		PreparedStatement pstm = null;
		conn = connectionMaker.getConnection();
		try {

			//row count 라는 열 이름으로 해당 쿼리의 행 개수를 가져온다.
			String query = "select count(*) as rowcount from cUser where account=? and password=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, account);
			pstm.setString(2, password);
			
			//쿼리를 실행하고
			ResultSet rs = pstm.executeQuery();
			
			//개수를 가져온다
			rs.next();
			int count = rs.getInt("rowcount");
			System.out.println("개수 : " + count);
			
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(pstm!=null)
						pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				connectionMaker.closeConnection(conn);
		}
		return 0;
	}
	
	public ArrayList<CDtoCircle> showCircle(String account){
		ArrayList<CDtoCircle> dtos= new ArrayList<CDtoCircle>();
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet resultSet = null;
		
		try{

			String query = "select * from cCircle where circle_id=(select circle_id from cUser_Circle where user_id=?)";
			conn = connectionMaker.getConnection();			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, account);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()){
				
				System.out.println("here something!");
				int circle_id = resultSet.getInt("circle_id");
				String name = resultSet.getString("name");
				int membercount = resultSet.getInt("membercount");
				int univ_id = resultSet.getInt("univ_id");
				
				CDtoCircle dto = new CDtoCircle(circle_id,name,membercount,univ_id);
				dtos.add(dto);  
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			
			connectionMaker.closeConnection(conn);
			
			try{
				
				if(resultSet != null)resultSet.close();
				if(pstmt != null)pstmt.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
}