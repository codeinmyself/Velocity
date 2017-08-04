package xmu.mall.usercenter.ljd.service.impls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.ljd.mapper.RegionMapper;
import xmu.mall.usercenter.ljd.mapper.UsersAddressMapper;
import xmu.mall.usercenter.ljd.model.Region;
import xmu.mall.usercenter.ljd.model.User_address;
import xmu.mall.usercenter.ljd.service.UsersAddressService;

@Service("UsersAddressService")
@Transactional
public class UsersAddressServiceImpl implements UsersAddressService {
	
	@Autowired
	private UsersAddressMapper usersaddressMapper;
	
	@Autowired
	private RegionMapper regionMapper;
	
	@Override
	public User_address selectByAddressID(long address_id){
		return usersaddressMapper.selectByAddressID(address_id);
	}
	
	@Override
	public List<User_address> selectAllByUserID(long user_id){
		return usersaddressMapper.selectAllByUserID(user_id);
	}
	
	@Override
	public List<Region> selectAllRegion(){
		return regionMapper.selectAll();
	}
	
	@Override
	public List<Region> selectAllRegionByParentID(int parent_id){
		return regionMapper.selectAllRegionByParentID(parent_id);
	}
	
	@Override
	public boolean updateUserAddress(User_address user_address){
		usersaddressMapper.updateUserAddress(user_address);
		
		return true;
	}
	
	@Override
	public boolean setDefaultAddress(User_address user_address){
		usersaddressMapper.cancelDefaultAddressByUserID(user_address);
		usersaddressMapper.setDefaultAddressByUserIDAndAddressID(user_address);
		
		return true;
	}
	
	@Override
	public boolean deleteUserAddressByAddressID(long address_id){
		usersaddressMapper.deleteUserAddressByAddressID(address_id);
		
		return true;
	}
	
	@Override
	public boolean add(User_address user_address){
		usersaddressMapper.add(user_address);
		
		return true;
	}
		
}
