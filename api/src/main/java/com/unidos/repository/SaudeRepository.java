package com.unidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.unidos.entity.Saude;
import com.unidos.enums.TipoSangue;

@Transactional(readOnly = true)
public interface SaudeRepository  extends JpaRepository<Saude, Long>{
	
	@Query("SELECT " 
            + "CASE " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 0 AND 10 THEN '0-10 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 11 AND 20 THEN '11-20 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 21 AND 30 THEN '21-30 anos' "
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 31 AND 40 THEN '31-40 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 41 AND 50 THEN '41-50 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 51 AND 60 THEN '51-60 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 61 AND 70 THEN '61-70 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 71 AND 80 THEN '71-80 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 81 AND 90 THEN '81-90 anos' " 
            + "WHEN (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 91 AND 100 THEN '91-100 anos' " 
            + "ELSE '100+ anos' " 
            + "END AS faixa_etaria, " 
            + "AVG(ABS(s.peso / (s.altura * s.altura))) " 
            + "FROM Saude s " 
            + "GROUP BY faixa_etaria " 
            + "ORDER BY faixa_etaria")
    List<Object[]> countByIMC();
    
    @Query("SELECT count(s.id),"
    		+ "CASE "
    		+ "WHEN s.sexo = 0 THEN 'Feminino' "
    		+ "ELSE 'Masculino' "
    		+ "END "
    		+ "FROM Saude s WHERE ROUND(s.peso/(s.altura * s.altura),2) > 30 GROUP BY s.sexo ")
    List<Object[]> countByObesidade();
    
    @Query("SELECT "
    		+ "s.tpSangue, "
    		+ "ROUND(AVG((YEAR(CURRENT_DATE) - YEAR(s.dtNascimento))),0) "
    		+ "FROM Saude s "
    		+ "GROUP BY s.tpSangue")
    List<Object[]> countByMediaIdadePorTipoSangue();
    
    @Query("SELECT SUM(CASE WHEN s.tpSangue in :tipos THEN 1 ELSE 0 END) FROM Saude s "
    		+ "WHERE (YEAR(CURRENT_DATE) - YEAR(s.dtNascimento)) BETWEEN 16 AND 69 "
    		+ "AND s.peso > 50")
    Integer countByDoadoresPorReceptores(@Param("tipos") List<TipoSangue> tipos);

}
