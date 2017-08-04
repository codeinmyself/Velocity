package xmu.mystore.logmgt.xlx.TypeHandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes({Date.class})
@MappedJdbcTypes({JdbcType.BIGINT})
public class LongDateTypeHandler extends BaseTypeHandler<Date>{

	@Override
	public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
		
		return getDatefromLong(rs.getLong(columnName));
	}

	@Override
	public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

		return getDatefromLong(rs.getLong(columnIndex));
	}

	@Override
	public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

		return getDatefromLong(cs.getLong(columnIndex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {
		ps.setLong(i,date.getTime());
		
	}
	
	private Date getDatefromLong(long timestamp)
	{
		return new Date(timestamp);	
	}
		
	

}
