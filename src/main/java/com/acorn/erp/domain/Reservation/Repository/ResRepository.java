package com.acorn.erp.domain.Reservation.Repository;



import java.util.List;



import org.apache.ibatis.annotations.Delete;

import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Repository;


import com.acorn.erp.domain.Reservation.Entity.Reservation;



@Mapper
@Repository
public interface ResRepository {



    @Select("SELECT * FROM reservation")
    List<Reservation> getAllReservations();



    @Select("SELECT * FROM reservation WHERE id = #{id}")
    Reservation getReservation(String id);



    @Insert("INSERT INTO reservation(id, name, reservation_date, requests, payment, phone, gender, rs_count) VALUES (#{id}, #{name}, #{reservationDate}, #{requests}, #{payment}, #{phone}, #{gender}, #{rsCount})")
    void insertReservation(Reservation reservation);



    @Delete("DELETE FROM reservation WHERE id = #{id}")
    void deleteReservation(String id);



    @Update("UPDATE reservation SET name = #{name}, reservation_date = #{reservationDate}, requests = #{requests}, payment = #{payment}, phone = #{phone}, gender = #{gender}, rs_count = #{rsCount} WHERE id = #{id}")
    void updateReservation(Reservation reservation);

}