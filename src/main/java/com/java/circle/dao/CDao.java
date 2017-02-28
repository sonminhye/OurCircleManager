package com.java.circle.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.circle.dto.CDto;

public class CDao {

	DataSource dataSource;
	
	public CDao(){
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/circle");
			
            System.out.println("connected");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("context error");
		}
	}
	
	
	
	public ArrayList<CDto> showList(){
		ArrayList<CDto> dtos= new ArrayList<CDto>();
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet resultSet = null;
		
		try{
			System.out.println("1!");
			//�����ͺ��̽��� ��� �ڷ� ������
			String query = "select user_id, account, password, name, auth_id, univ_id from cUser order by user_id desc";
			conn = dataSource.getConnection();
			System.out.println("2!");
			
			pstmt = conn.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			
			
			while(resultSet.next()){
				
				System.out.println("here something!");
				int user_id = resultSet.getInt("user_id");
				String account = resultSet.getString("account");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				int auth_id = resultSet.getInt("auth_id");
				String univ_id = resultSet.getString("univ_id");
				
				
				CDto dto = new CDto(user_id, account, password, name, auth_id, univ_id);
				dtos.add(dto);  //����������߰� 
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				//�پ��ڷ���� ��ȯ
				if(resultSet != null)resultSet.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
}