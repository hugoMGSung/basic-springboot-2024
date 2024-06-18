package com.hugo83.backboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hugo83.backboard.entity.Board;
import com.hugo83.backboard.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {        
    private final BoardRepository boardRepository;

    public List<Board> getList() {
        return this.boardRepository.findAll();
    }
}
