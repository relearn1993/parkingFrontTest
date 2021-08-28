package choi.seowon.board.domain.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import choi.seowon.board.domain.Entity.BoardEntity;
import choi.seowon.board.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
	//Board findByNickname(String nickname);
	List<BoardEntity> findByTitleContaining(String keyword);
	
}
