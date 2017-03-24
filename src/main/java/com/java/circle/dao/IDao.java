package com.java.circle.dao;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.java.circle.dto.CDto;

@Repository(value="IDao")
public interface IDao {
	public ArrayList<CDto> showList();
}
