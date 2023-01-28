package se.jensenyh.javacourse.saltmerch.backend.repository;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import se.jensenyh.javacourse.saltmerch.backend.Tests;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryMockedDBUnitTest extends Tests {
    @Mock
    JdbcTemplate jdbcTemplate;
    @Mock
    NamedParameterJdbcTemplate nPJT;
    @InjectMocks
    ProductRepository repository;

    @Test
    public void selectAll() {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", null);

        when(nPJT.query(anyString(), eq(paramMap)
                ,any(RowMapper.class))).thenReturn(products);
        assertEquals(products, repository.selectAll());
    }

    @Test
    public void selectAllOfCategory() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", "hats");

        Mockito.when(nPJT.query(anyString(), eq(paramMap), any(RowMapper.class))).thenReturn(prod1_Hats);
        assertEquals(prod1_Hats, repository.selectAllOfCategory(prod1_Category));
    }

}