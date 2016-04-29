$(function(){

    $('#switch_signin').click(function(){
        $('#switch_signup').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_signin').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_bottom').animate({left:'0px',width:'36px'});
        $('#form_signup').css('display','none');
        $('#form_login').css('display','block');

    });
    $('#switch_signup').click(function(){
        $('#switch_signup').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_signin').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_bottom').animate({left:'76px',width:'36px'});
        $('#form_login').css('display','none');
        $('#form_signup').css('display','block');
    });

    $('#jobseeker-radio').click(function() {
        $('#company-info').css('display','none');
        $('#jobseeker-info').css('display','block');
    });
    $('#company-radio').click(function() {
        $('#jobseeker-info').css('display','none');
        $('#company-info').css('display','block');
    });
});
