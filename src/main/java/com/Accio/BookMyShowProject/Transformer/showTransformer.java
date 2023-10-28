package com.Accio.BookMyShowProject.Transformer;

import com.Accio.BookMyShowProject.Models.Show;
import com.Accio.BookMyShowProject.dtos.addshowdto;

public class showTransformer {
    public static Show showdtoToShow(addshowdto addshowdto){
        Show show=Show.builder()
                .showDate(addshowdto.getShowDate())
                .showTime(addshowdto.getShowTime())
                .build();
        return show;
    }
}
