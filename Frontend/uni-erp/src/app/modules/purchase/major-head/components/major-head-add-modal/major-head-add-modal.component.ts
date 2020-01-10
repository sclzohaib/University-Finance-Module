import { MajorHead } from './../../../../../core/models/Purchase/major-head';
import { MajorHeadService } from './../../../../../core/services/Purchase/major-head.service';
import { Component, OnInit } from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-major-head-add-modal',
  templateUrl: './major-head-add-modal.component.html',
  styleUrls: ['./major-head-add-modal.component.less']
})
export class MajorHeadAddModalComponent implements OnInit {

	majorHead: MajorHead = new MajorHead();
  constructor(private majorHeadService: MajorHeadService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	saveMajorHead(){
		// console.log(this.authLvl);
		this.majorHeadService.saveMajorHead(this.majorHead).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `Major Head Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Level Successfully Added!`);
				this.message.create('error', `Major Head Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

}
