/**
 *
 * Responsive website using AngularJS
 * http://www.script-tutorials.com/responsive-website-using-angularjs/
 *
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 *
 * Copyright 2013, Script Tutorials
 * http://www.script-tutorials.com/
 */

'use strict';

// angular.js main app initialization
var app = angular.module('bi', []).
config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'bi-dashboard.jsp',
            activetab: 'dashboard',
            controller: HomeCtrl,
	    controllerAs : "homectrl"
        }).
	when('/manualdatapajak', {
            templateUrl: 'datapajak/manual_data_pajak.jsp',
            controller: ManualDataPajak,
            activetab: 'manualdatapajak',
	    controllerAs : "manualdatapajak"
	}).
        when('/otomaticdatapajak', {
            templateUrl: 'datapajak/otomatic_data_pajak.jsp',
            controller: OtomaticDataPajak,
            activetab: 'otomaticdatapajak',
	    controllerAs : "otomaticdatapajak"
	}).
	when('/pencapaianhariini', {
            templateUrl: 'bi-pendapatanperjenispajak/bi-pencapaianhariini.jsp',
            controller: PencapaianHariIni,
            activetab: 'pencapaianhariini',
	    controllerAs : "pencapaianhariini"
	}).
	when('/pencapaianpadabulan', {
            templateUrl: 'bi-pendapatanperjenispajak/bi-pencapaianbulantertentu.jsp',
            controller: PencapaianPadaBulan,
            activetab: 'pencapaianpadabulan',
	    controllerAs : "pencapaianpadabulan"
	}).
	when('/perbandingan2tahun', {
            templateUrl: 'bi-pendapatanperjenispajak/bi-perbandingan2tahun.jsp',
            controller: Perbandingan2Tahun,
            activetab: 'perbandingan2tahun',
	    controllerAs : "perbandingan2tahun"
	}).
	when('/perbandingan3tahun', {
            templateUrl: 'bi-pendapatanperjenispajak/bi-perbandingan3tahun.jsp',
            controller: Perbandingan3Tahun,
            activetab: 'perbandingan3tahun',
	    controllerAs : "perbandingan3tahun"
	}).
	when('/komposisiphr', {
            templateUrl: 'bi-pendapatanphrdetail/bi-komposisiphr.jsp',
            controller: KomposisiPHR,
            activetab: 'komposisiphr',
	    controllerAs : "komposisiphr"
	}).
	when('/proyeksipendapatan', {
            templateUrl: 'bi-pendapatanperjenispajak/bi-proyeksipendapatan.jsp',
            controller: ProyeksiPendapatan,
            activetab: 'proyeksipendapatan',
	    controllerAs : "proyeksipendapatan"
	}).
	when('/tampilkantarget', {
            templateUrl: 'bi-perencanaan/bi-tampilkantarget.jsp',
            controller: TampilkanTarget,
            activetab: 'tampilkantarget',
	    controllerAs : "tampilkantarget"
	}).
        when('/tampilkanlistuser', {
            templateUrl: 'system/bi_userlist.jsp',
            controller: TampilkanListUser,
            activetab: 'tampilkanlistuser',
	    controllerAs : "tampilkanlistuser"
	}).
        when('/inputtarget', {
            templateUrl: 'bi-perencanaan/bi-input-target.jsp',
            controller: InputTarget,
            activetab: 'inputtarget',
	    controllerAs : "inputtarget"
	}).        
        when('/tampilkangrouplist', {
            templateUrl: 'system/bi_grouplist.jsp',
            controller: TampilkanGroupList,
            activetab: 'tampilkangrouplist',
	    controllerAs : "tampilkangrouplist"
	}).
        when('/tampilkanprivilage', {
            templateUrl: 'system/bi_privilagelist.jsp',
            controller: TampilkanPrivilage,
            activetab: 'tampilkanprivilage',
	    controllerAs : "tampilkanprivilage"
	}).   
	when('/top10wp', {
            templateUrl: 'bi-pendapatanperwp/bi-top10wp.jsp',
            controller: Top10WP,
            activetab: 'top10wp',
	    controllerAs : "top10wp"
	}).
	when('/perdesa', {
            templateUrl: 'bi-perareawp/bi-perdesa.jsp',
            controller: PerDesa,
            activetab: 'perdesa',
	    controllerAs : "perdesa"
	}).
	when('/perkecamatan', {
            templateUrl: 'bi-perareawp/bi-perkecamatan.jsp',
            controller: PerKecamatan,
            activetab: 'perkecamatan',
	    controllerAs : "perkecamatan"
	}).	
        otherwise({
            templateUrl: 'bi-dashboard.jsp',
            activetab: 'dashboard',
            controller: HomeCtrl
        });
    }
]);

app.config(['$locationProvider',
    function($location) {
        $location.hashPrefix('!');
    }
]);
