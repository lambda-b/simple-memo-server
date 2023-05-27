package com.web.memo.dao.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

/**
 * LocalDateTimeTypeHandler
 */
@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {

	@Override
	public void setNonNullParameter(final PreparedStatement ps, final int i, final LocalDateTime parameter, final JdbcType jdbcType)
			throws SQLException {
		ps.setTimestamp(i, Timestamp.valueOf(parameter));
	}

	@Override
	public LocalDateTime getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
		final Timestamp timestamp = rs.getTimestamp(columnName);
		return timestamp != null ? timestamp.toLocalDateTime() : null;
	}

	@Override
	public LocalDateTime getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
		final Timestamp timestamp = rs.getTimestamp(columnIndex);
		return timestamp != null ? timestamp.toLocalDateTime() : null;
	}

	@Override
	public LocalDateTime getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		final Timestamp timestamp = cs.getTimestamp(columnIndex);
		return timestamp != null ? timestamp.toLocalDateTime() : null;
	}

}
