import { Component, OnInit } from '@angular/core';
import { MinorHead } from 'src/app/core/models/Purchase/minor-head';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { MinorHeadService } from 'src/app/core/services/Purchase/minor-head.service';
import { MajorHeadService } from 'src/app/core/services/Purchase/major-head.service';

@Component({
  selector: 'app-minor-head-add-modal',
  templateUrl: './minor-head-add-modal.component.html',
  styleUrls: ['./minor-head-add-modal.component.less']
})
export class MinorHeadAddModalComponent implements OnInit {

	majorHeads: any = [];
	minorHead: MinorHead = new MinorHead();
  constructor(
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private minorHeadService: MinorHeadService,
		private majorHeadService: MajorHeadService
	) { }

  ngOnInit() {
		this.getAllMajorHead();
	}

	saveMinorHead(){
		// console.log(this.minorHead);
		this.minorHeadService.saveMinorHead(this.minorHead).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `Minor Head Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Signatory Successfully Added!`);
				this.message.create('error', `Minor Head Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

public getAllMajorHead(){
	this.majorHeadService.getAllMajorHead().subscribe(
			data => {
					this.majorHeads = data;


			},
			error => {

				if(error['status']=='404'){
					this.majorHeads = [];
				}
					else if(error.error){
					this.majorHeads = error.error;
			}



			}
	);
}

}
