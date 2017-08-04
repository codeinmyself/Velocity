package xmu.mall.usercenter.lxq.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.lxq.model.OrderInfo;

@Component
public interface OrderInfoMapper {
	/**
	 * 通过用户id查找订单
	 * 
	 * @param id
	 * @return
	 */
	List<OrderInfo> getOrderListByUserId(Long id);

	/**
	 * 通过订单状态和用户id查找订单
	 * 
	 * @param id
	 * @return
	 */
	List<OrderInfo> selectStatus0OrderByUserId(Long id);

	/**
	 * 通过订单状态和用户id查找订单
	 * 
	 * @param id
	 * @return
	 */
	List<OrderInfo> selectStatus1OrderByUserId(Long id);

	/**
	 * 通过订单状态和用户id查找订单
	 * 
	 * @param id
	 * @return
	 */
	List<OrderInfo> selectStatus2OrderByUserId(Long id);

	/**
	 * 通过订单状态和用户id查找订单
	 * 
	 * @param id
	 * @return
	 */
	List<OrderInfo> selectStatus3OrderByUserId(Long id);

	/**
	 * 通过订单状态和用户id查找订单
	 * 
	 * @param id
	 * @return
	 */
	List<OrderInfo> selectStatus4OrderByUserId(Long id);

	List<OrderInfo> selectStatus5OrderByUserId(Long id);

	int delete(long id);

	int confirm_re(long id);

	int confirm_pay(long id);

}
