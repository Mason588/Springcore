package com.study.springcore.tx.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.springcore.tx.dao.BookDao;
import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;
	@Transactional(propagation = Propagation.REQUIRED,
			rollbackFor = {InsufficientAmount.class, InsufficientQuantity.class},
			noRollbackFor = {ArithmeticException.class}
	)
	// getConnection() , setAutocommit(false) , commit()
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientQuantity, InsufficientAmount {
		// 減去一本庫存
		bookDao.updateStock(bid, 1);
		//System.out.println(10/0); //產生ArithmeticException 錯誤(根據上面的定義資料庫會不做回滾)
		// 取得書籍價格
		if(true) {
			throw new Error();
		}
		Integer price = bookDao.getPrice(bid);
		//減去錢包裡的金額
		bookDao.updateWallet(wid, price);
		//Log ...
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientQuantity, InsufficientAmount {
		//重複執行buyOne
		for(Integer bid :bids) {
			buyOne(wid,bid);
			
		}
		
	}

}
